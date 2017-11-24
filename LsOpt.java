import java.io.File;
import java.util.Date;

public class LsOpt {
    LsFile file;

    public LsOpt(String[] args) {
        this.file = new LsFile(args);
    }

    public void run() {
        file.getOption();

        if (file.opt().contains('r')) {
            for (int i = 0; i < file.getFiles().length; i++) {
                if (file.opt().contains('a')) {
                    if (file.list().get(i).isHidden()) {
                        showFileInfo(file.list().get(i));
                    }
                }
                if (!file.list().get(i).isHidden()) {
                    showFileInfo(file.list().get(i));
                }
            }
        } else {
            for (File f : file.getArrayFile()) {
                if (file.opt().contains('a')) {
                    if (f.isHidden()) {
                        showFileInfo(f);
                    }
                }
                if (!f.isHidden()) {
                    showFileInfo(f);
                }
            }
        }

    }

    private void showFileInfo(File target) {

        this.showInfo(target);
    }

    private void showInfo(File file) {
        System.out.printf(
                "%s %6d %s %s %s%n",
                getMode(file),
                file.length(),
//                System.getenv(),
                System.getenv().get("USER"),
                new Date(file.lastModified()),
                file.getName()
        );
    }

    private String getMode(File file) {
        String rwx = "";
        // check read file
        if (file.canRead()) rwx += "r";
        else rwx += "-";

        // check write file
        if (file.canWrite()) rwx += "w";
        else rwx += "-";

        // check execute file
        if (file.canExecute()) rwx += "w";
        else rwx += "-";

        return rwx;
    }
}
