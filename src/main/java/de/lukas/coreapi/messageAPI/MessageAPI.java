package de.lukas.coreapi.messageAPI;

public class MessageAPI {

    public String getPrefix() {return "§bSystem §8| ";}

    // Error Messages
    public ErrorMessages getErrorMessages() {return new ErrorMessages();}

    // Color Scheme
    public String Color_Error() {return "§c";}
    public String Color_Normal() {return "§7";}
    public String Color_Highlight() {return "§e";}


}
