package org.mcausc78.malc;

import org.mcausc78.malc.permissions.Mode;

public class Calculator {
    private Mode mode;
    public Calculator(Mode mode) {
        this.setMode(mode);
    }
    public Mode getMode() {
        return this.mode;
    }

    public void setMode(Mode mode) {
        if (mode == null) throw new NullPointerException("mode field is null");
        this.mode = mode;
    }

    public String toString() {
        return String.format("chmod %d%d%d myfile.txt", this.getMode().getOwnerPermissions().toInt(), this.getMode().getGroupPermissions().toInt(), this.getMode().getUsersPermissions().toInt());
    }
}
