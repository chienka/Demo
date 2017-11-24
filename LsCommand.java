

public class LsCommand {
    public static void main(String[] args) {
        LsFile f = new LsFile(args);
        if (args[0].equals("ls")) {
            if (args.length == 1) {
                f.getName();
            } else {
                f.getOption();
                if (f.opt().contains('l')) {
                    LsOpt lsOpt = new LsOpt(args);
                    lsOpt.run();
                } else if (f.opt().contains('a') || f.opt().contains('t') || f.opt().contains('r')) {
                    f.getName();
                }
            }
        } else {
            System.out.println("command not found");
        }
    }
}
