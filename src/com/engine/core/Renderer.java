package com.engine.core;

import java.awt.image.DataBufferInt;
import java.util.ArrayList;

import com.engine.core.fx.Font;
import com.engine.core.fx.Image;
import com.engine.core.fx.Light;
import com.engine.core.fx.ShadowType;
import com.engine.core.fx.ImageTile;
import com.engine.core.fx.LightRequest;
import com.engine.core.fx.Pixel;

public class Renderer {
	private GameContainer gc;

	private int width, height;
	private int[] pixels;
	private int[] lightMap; // lightMap
	private ShadowType[] shadowsMap; // lightBlock
	private Font font = Font.STANDARD;
	public int ambientLight = Pixel.getColor(1, 0.2f, 0.2f, 0.2f);
	private int clearColor = 0xff000000;
	
	private int transX, transY;

	private ArrayList<LightRequest> lightRequests = new ArrayList<LightRequest>();

	public Renderer(GameContainer gc) {
		this.gc = gc;
		width = gc.getWidth();
		height = gc.getHeight();
		pixels = ((DataBufferInt) gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
		lightMap = new int[pixels.length];
		shadowsMap = new ShadowType[pixels.length];
	}

	public void setPixel(int x, int y, int color, ShadowType shadowMap) {
		x-= transX;
		y-= transY;
		
		if (x < 0 || x >= width || y < 0 || y >= height || color == 0xffff00ff) {
			return;
		}

		pixels[x + y * width] = color;
		shadowsMap[x + y * width] = shadowMap;
	}

	public ShadowType getLightBlock(int x, int y) {
		x-= transX;
		y-= transY;
		
		if (x < 0 || x >= width || y < 0 || y >= height)
			return ShadowType.TOTAL;
		return shadowsMap[x + y * width];
	}

	public void setLightMap(int x, int y, int color) {
		x-= transX;
		y-= transY;
		
		if (x < 0 || x >= width || y < 0 || y >= height) {
			return;
		}

		lightMap[x + y * width] = Pixel.getMax(color, lightMap[x + y * width]);
	}

	public void drawString(String text, int color, int offx, int offy) {
		text = text.toUpperCase();

		int offset = 0;

		for (int i = 0; i < text.length(); i++) {
			int unicode = text.codePointAt(i) - 32;

			for (int x = 0; x < font.widths[unicode]; x++) {
				for (int y = 1; y < font.image.height; y++) {
					if (font.image.pixels[(x + font.offsets[unicode]) + y * font.image.width] == 0xffffffff)
						setPixel(x + offx + offset, y + offy - 1, color, ShadowType.NONE);
				}
			}

			offset += font.widths[unicode];
		}
	}

	public void clear() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				pixels[x + y * width] = clearColor;
			}
		}

	}

	public void flushMaps() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				setPixel(x, y, Pixel.getLightBlend(pixels[x + y * width], lightMap[x + y * width], ambientLight),
						shadowsMap[x + y * width]);
				lightMap[x + y * width] = ambientLight;
			}
		}

	}

	public void drawLightArray() {
		for (LightRequest lr : lightRequests) {
			drawLightRequest(lr.light, lr.x, lr.y);
		}

		lightRequests.clear();
	}

	public void drawImage(Image image, int offx, int offy) {
		for (int x = 0; x < image.width; x++) {
			for (int y = 0; y < image.height; y++) {
				setPixel(x + offx, y + offy, image.pixels[x + y * image.width], image.shadowType);
			}
		}
	}

	public void drawImageTile(ImageTile image, int offx, int offy, int tileX, int tileY) {
		for (int x = 0; x < image.tileWidth; x++) {
			for (int y = 0; y < image.tileHeight; y++) {
				setPixel(x + offx, y + offy,
						image.pixels[(x + (tileX * image.tileWidth)) + (y + (tileY * image.tileHeight)) * image.width],
						image.shadowType);
			}
		}
	}
	
	
	public void drawRect(int offX, int offY, int width, int height, int color, ShadowType type){
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				setPixel(x+offX, y + offY, color, type);
			}
		}
	}

	public void drawLight(Light light, int offX, int offY) {
		if(gc.isDynamicLights() || gc.isLightEnable())
			lightRequests.add(new LightRequest(light, offX, offY));

	}

	private void drawLightRequest(Light light, int offX, int offY) {
		if (gc.isDynamicLights()) {
			for (int i = 0; i <= light.diameter; i++) {
				drawLightLine(light.radius, light.radius, i, 0, light, offX, offY);
				drawLightLine(light.radius, light.radius, i, light.diameter, light, offX, offY);
				drawLightLine(light.radius, light.radius, 0, i, light, offX, offY);
				drawLightLine(light.radius, light.radius, light.diameter, i, light, offX, offY);
			}
		} else {
			for (int x = 0; x < light.diameter; x++) {
				for (int y = 0; y < light.diameter; y++) {
					setLightMap(x + offX - light.radius, y + offY - light.radius, light.getLightValue(x, y));
				}
			}
		}
	}


	private void drawLightLine(int x0, int y0, int x1, int y1, Light light, int offX, int offY) {
		int dx = Math.abs(x1 - x0);
		int dy = Math.abs(y1 - x0);

		int sx = x0 < x1 ? 1 : -1;
		int sy = y0 < y1 ? 1 : -1;

		int err = dx - dy;
		int e2 = 0;

		float power = 1.0f;
		boolean hit = false;

		while (true) {
			if (light.getLightValue(x0, y0) == 0xff000000)
				break;

			int screenX = x0 - light.radius + offX;
			int screeny = y0 - light.radius + offY;

			if (power == 1) {
				setLightMap(screenX, screeny, light.getLightValue(x0, y0));
			} else {
				setLightMap(screenX, screeny, Pixel.getColorPower(light.getLightValue(x0, y0), power));
			}

			if (x0 == x1 && y0 == y1)
				break;
			if (getLightBlock(screenX, screeny) == ShadowType.TOTAL)
				break;
			if (getLightBlock(screenX, screeny) == ShadowType.FADE)
				power -= 0.005f; //fade decreasing factor
			if (getLightBlock(screenX, screeny) == ShadowType.HALF && !hit) {
				hit = true;
				power /= 2;
			}
			if (getLightBlock(screenX, screeny) == ShadowType.NONE && hit) {
				hit = false;
			}

			if (power <= 0.1)
				break;

			e2 = 2 * err;
			if (e2 > -1 * dy) {
				err -= dy;
				x0 += sx;
			}
			if (e2 < dx) {
				err += dx;
				y0 += sy;
			}
		}

	}

	public int getClearColor() {
		return clearColor;
	}

	public void setClearColor(int clearColor) {
		this.clearColor = clearColor;
	}

	public int getAmbientLight() {
		return ambientLight;
	}


	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public int getTransX() {
		return transX;
	}

	public void setTransX(int transX) {
		this.transX = transX;
	}

	public int getTransY() {
		return transY;
	}

	public void setTransY(int transY) {
		this.transY = transY;
	}

	public void drawImage (Image image){
		drawImage(image,0,0);
	}
	
	public void drawImageTile (ImageTile image,int tileX,int tileY){
		drawImageTile(image,0,0, tileX, tileY);
	}

	public void drawLight (Light light){
		drawLight(light,0,0);
	}
	
	public void drawRect(int offX, int offY, int width, int height, int color){
		drawRect(offX, offY, width, height, color, ShadowType.NONE);
	}
}







