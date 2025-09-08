package com.sbi.nps;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
/**
 * Utility class to provide common Selenium Actions methods.
 */
public class ActionUtility {
    /** Actions for performing action.*/
    private Actions actions;
    /**
     * Constructor to initialize Actions instance.
     *
     * @param driver WebDriver instance
     */
    public ActionUtility(final WebDriver driver) {
        this.actions = new Actions(driver);
    }
    /**
     * Clicks on the specified WebElement.
     *
     * @param element WebElement to click
     */
    public void click(final WebElement element) {
        actions.click(element).perform();
    }
    /**
     * Clicks at the current mouse location.
     */
    public void click() {
        actions.click().perform();
    }
    /**
     * doubleClick on the specified WebElement.
     *
     * @param element WebElement to doubleClick
     */
    public void doubleClick(final WebElement element) {
        actions.doubleClick(element).perform();
    }
    /**
     * doubleClick at the current mouse location.
     */
    public void doubleClick() {
        actions.doubleClick().perform();
    }
    /**
     * rightClick on the specified WebElement.
     *
     * @param element WebElement to rightClick
     */
    public void rightClick(final WebElement element) {
        actions.contextClick(element).perform();
    }
    /**
     * rightClick at the current mouse location.
     */
    public void rightClick() {
        actions.contextClick().perform();
    }
    /**
     * moveToElement on the specified WebElement.
     *
     * @param element WebElement to moveToElement
     */
    public void moveToElement(final WebElement element) {
        actions.moveToElement(element).click().perform();
    }
    /**
     * moveToElement on the specified WebElement.
     *
     * @param element WebElement to moveToElement
     * @param xOffset WebElement to moveToElement
     * @param yOffset WebElement to moveToElement
     */
    public void moveToElement(final WebElement element,
        final int xOffset, final int yOffset) {
        actions.moveToElement(element, xOffset, yOffset).perform();
    }
    /**
     * moveByOffset on the specified WebElement.
     *
     * @param xOffset WebElement to moveByOffset
     * @param yOffset WebElement to moveByOffset
     */
    public void moveByOffset(final int xOffset, final int yOffset) {
        actions.moveByOffset(xOffset, yOffset).perform();
    }
    /**
     * hover on the specified WebElement.
     *
     * @param element WebElement to hover
     */
    public void hover(final WebElement element) {
        actions.moveToElement(element).perform();
    }
    /**
     * clickAndHold on the specified WebElement.
     *
     * @param element WebElement to clickAndHold
     */
    public void clickAndHold(final WebElement element) {
        actions.clickAndHold(element).perform();
    }
    /**
     * clickAndHold at the current mouse location.
     */
    public void clickAndHold() {
        actions.clickAndHold().perform();
    }
    /**
     * release on the specified WebElement.
     *
     * @param element WebElement to release
     */
    public void release(final WebElement element) {
        actions.release(element).perform();
    }
    /**
     * release at the current mouse location.
     */
    public void release() {
        actions.release().perform();
    }
    /**
     * sendKeys on the specified WebElement.
     *
     * @param element WebElement to sendKeys
     * @param keys WebElement to sendKeys
     */
    public void sendKeys(final WebElement element, final CharSequence keys) {
        actions.sendKeys(element, keys).perform();
    }
    /**
     * sendKeys on the specified WebElement.
     *
     * @param keys WebElement to sendKeys
     */
    public void sendKeys(final CharSequence keys) {
        actions.sendKeys(keys).perform();
    }
    /**
     * keyDown on the specified WebElement.
     *
     * @param key WebElement to keyDown
     */
    public void keyDown(final Keys key) {
        actions.keyDown(key).perform();
    }
    /**
     * keyDown on the specified WebElement.
     *
     * @param element WebElement to keyDown
     * @param key WebElement to keyDown
     */
    public void keyDown(final WebElement element, final Keys key) {
        actions.keyDown(element, key).perform();
    }
    /**
     * keyUp on the specified WebElement.
     *
     * @param key WebElement to keyUp
     */
    public void keyUp(final Keys key) {
        actions.keyUp(key).perform();
    }
    /**
     * keyUp on the specified WebElement.
     *
     * @param element WebElement to keyUp
     * @param key WebElement to keyUp
     */
    public void keyUp(final WebElement element, final Keys key) {
        actions.keyUp(element, key).perform();
    }
    /**
     * dragAndDrop on the specified WebElement.
     *
     * @param source WebElement to dragAndDrop
     * @param target WebElement to dragAndDrop
     */
    public void dragAndDrop(final WebElement source, final WebElement target) {
        actions.dragAndDrop(source, target).perform();
    }
    /**
     * dragAndDropBy on the specified WebElement.
     *
     * @param source WebElement to dragAndDropBy
     * @param xOffset WebElement to dragAndDropBy
     * @param yOffset WebElement to dragAndDropBy
     */
    public void dragAndDropBy(final WebElement source,
        final int xOffset, final int yOffset) {
        actions.dragAndDropBy(source, xOffset, yOffset).perform();
    }
    /**
     * scrollToElement on the specified WebElement.
     *
     * @param deltaX  WebElement to scrollToElement
     * @param deltaY  WebElement to scrollToElement
     */
    public void scrollByAmount(final int deltaX, final int deltaY) {
        actions.scrollByAmount(deltaX, deltaY).perform();
    }
    /**
     * scrollToElement on the specified WebElement.
     *
     * @param element WebElement to scrollToElement
     */
    public void scrollToElement(final WebElement element) {
        actions.scrollToElement(element).perform();
    }
    /**
     * Perform action.
     */
    public void perform() {
        actions.perform();
    }
    /**
     * build the action.
     */
    public void build() {
        actions.build().perform();
    }
}


