package de.lukas.coreapi.utils;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class TextComponents {

    public void suggest_command(String text, String cmd) {
        TextComponent tc = new TextComponent(text);
        tc.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, cmd));
    }

    public void suggest_command(String text, String hovertext, String cmd) {
        TextComponent tc = new TextComponent(text);
        tc.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, cmd));
        tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(hovertext)));
    }

    public void run_command(String text, String cmd) {
        TextComponent tc = new TextComponent(text);
        tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, cmd));
    }

    public void run_command(String text, String hovertext, String cmd) {
        TextComponent tc = new TextComponent(text);
        tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, cmd));
        tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(hovertext)));
    }

    public void copy_to_clipboard(String text, String copy) {
        TextComponent tc = new TextComponent(text);
        tc.setClickEvent(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, copy));
    }

    public void copy_to_clipboard(String text, String hovertext, String copy) {
        TextComponent tc = new TextComponent(text);
        tc.setClickEvent(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, copy));
        tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(hovertext)));
    }

    public void open_url(String text, String url) {
        TextComponent tc = new TextComponent(text);
        tc.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, url));
    }

    public void open_url(String text, String hovertext, String url) {
        TextComponent tc = new TextComponent(text);
        tc.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, url));
        tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(hovertext)));
    }

    public void change_page(String text, String page) {
        TextComponent tc = new TextComponent(text);
        tc.setClickEvent(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, page));
    }

    public void change_page(String text, String hovertext, String page) {
        TextComponent tc = new TextComponent(text);
        tc.setClickEvent(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, page));
        tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(hovertext)));
    }

    public void open_file(String text, String file) {
        TextComponent tc = new TextComponent(text);
        tc.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, file));
    }

    public void open_file(String text, String hovertext, String file) {
        TextComponent tc = new TextComponent(text);
        tc.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, file));
        tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(hovertext)));
    }

}
