package com.just.demo19.domain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Poker extends JLabel implements MouseListener {

	String name;

	boolean up = false;

	boolean canClick = false;

	boolean clicked = false;

	public Poker(String name, boolean up){
		this.name = name;
		this.up = up;

		if (this.up) {
			turnFront();
		} else {
			turnRear();
		}

		this.setSize(71, 96);
		this.setVisible(true);
		this.addMouseListener(this);
	}

	public Poker(String name, boolean up, boolean canClick, boolean clicked) {
		this.name = name;
		this.up = up;
		this.canClick = canClick;
		this.clicked = clicked;
	}

	public void turnFront(){
		this.setIcon(new ImageIcon("C:\\Users\\49744\\Documents\\basic_code\\src\\com\\just\\demo19\\image\\poker\\" + this.getName() + ".png"));
		this.up = true;
	}

	public void turnRear(){
		this.setIcon(new ImageIcon("C:\\Users\\49744\\Documents\\basic_code\\src\\com\\just\\demo19\\image\\poker\\rear.png"));
		this.up = false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (canClick) {
			int step = 0;
			if (clicked) {
				step = 20;
			} else {
				step = -20;
			}
			Point form = this.getLocation();
			Point to = new Point(form.x, form.y + step);
			this.setLocation(to);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	/**
	 * 获取
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取
	 * @return up
	 */
	public boolean isUp() {
		return up;
	}

	/**
	 * 设置
	 * @param up
	 */
	public void setUp(boolean up) {
		this.up = up;
	}

	/**
	 * 获取
	 * @return canClick
	 */
	public boolean isCanClick() {
		return canClick;
	}

	/**
	 * 设置
	 * @param canClick
	 */
	public void setCanClick(boolean canClick) {
		this.canClick = canClick;
	}

	/**
	 * 获取
	 * @return clicked
	 */
	public boolean isClicked() {
		return clicked;
	}

	/**
	 * 设置
	 * @param clicked
	 */
	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}

	public String toString() {
		return "Poker{name = " + name + ", up = " + up + ", canClick = " + canClick + ", clicked = " + clicked + "}";
	}
}
