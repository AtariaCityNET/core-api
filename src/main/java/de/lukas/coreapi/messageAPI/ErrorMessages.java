package de.lukas.coreapi.messageAPI;

import de.lukas.coreapi.CoreAPI;

public class ErrorMessages {

    public String noPermission() {return CoreAPI.getMessageAPI.getPrefix() + CoreAPI.getMessageAPI.Color_Error() + "§cDu hast dazu leider keine Berechtigung.";}
    public String wrongCommandUsage(String rightCommandUsage) {return CoreAPI.getMessageAPI.getPrefix() + CoreAPI.getMessageAPI.Color_Error() + "Fehlerhafte Benutzung: " + rightCommandUsage;}

}
