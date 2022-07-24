package org.mcausc78.malc.permissions;

/*
1=x
2=w
3=wx
4=r
5=rx
6=rw
7=rwx
 */
public class RWX {

    private boolean readable = false;
    private boolean writeable = false;
    private boolean executable = false;
    public RWX() {}
    public RWX(boolean readable) {
        this.setReadable(readable);
    }
    public RWX(boolean readable, boolean writeable) {
        this.setReadable(readable);
        this.setWriteable(writeable);
    }
    public RWX(boolean readable, boolean writeable, boolean executable) {
        this.setReadable(readable);
        this.setWriteable(writeable);
        this.setExecutable(executable);
    }
    public void setReadable(boolean readable) {
        this.readable = readable;
    }
    public void setWriteable(boolean writeable) {
        this.writeable = writeable;
    }
    public void setExecutable(boolean executable) {
        this.executable = executable;
    }
    public boolean isReadable() {
        return this.readable;
    }
    public boolean isWriteable() {
        return this.writeable;
    }
    public boolean isExecutable() {
        return this.executable;
    }
    public int toInt() {
        //System.out.printf("[DEBUG] %s\n", this.toString());
        switch(this.toString()) {
            case "---": return 0;
            case "--x": return 1;
            case "-w-": return 2;
            case "-wx": return 3;
            case "r--": return 4;
            case "r-x": return 5;
            case "rw-": return 6;
            case "rwx": return 7;
        }
        return 0;
    }
    public String toString() {
        String r = this.isReadable()?"r":"-";
        String w = this.isWriteable()?"w":"-";
        String x = this.isExecutable()?"x":"-";
        return String.format("%s%s%s", r, w, x);
    }
}
