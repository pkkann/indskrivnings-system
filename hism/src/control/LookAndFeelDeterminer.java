
package control;

/**
 *
 * @author pkann
 */
public class LookAndFeelDeterminer {

    private String lookAndFeel;
    
    public LookAndFeelDeterminer() {
        String os = determineOS();
        determineLookAndFeel(os);
    }
    
    public String getLookAndFeel() {
        return lookAndFeel;
    }

    private String determineOS() {
        return System.getProperty("os.name");
    }
    
    private void determineLookAndFeel(String os) {
        switch(os.toUpperCase()) {
            case "LINUX":
                lookAndFeel = "GTK+";
                break;
            case "WINDOWS":
                lookAndFeel = "Windows";
                break;
            default:
                lookAndFeel = "Nimbus";
                break;
        }
    }
}