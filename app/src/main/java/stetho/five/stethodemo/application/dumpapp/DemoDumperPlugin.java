package stetho.five.stethodemo.application.dumpapp;

import com.facebook.stetho.dumpapp.ArgsHelper;
import com.facebook.stetho.dumpapp.DumpException;
import com.facebook.stetho.dumpapp.DumpUsageException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import com.raizlabs.android.dbflow.sql.language.Delete;

import java.io.PrintStream;
import java.util.Iterator;

import stetho.five.stethodemo.application.Injector;
import stetho.five.stethodemo.business.dao.model.Variable;

public final class DemoDumperPlugin implements DumperPlugin {

    private static final String PLUGIN_NAME = "DbPlugin";

    private static final String COMMAND_SEED = "seed";
    private static final String COMMAND_DROP = "drop";

    private final Injector injector;

    public DemoDumperPlugin(Injector injector) {
        this.injector = injector;
    }

    @Override
    public String getName() {
        return PLUGIN_NAME;
    }

    @Override
    public void dump(DumperContext dumpContext) throws DumpException {
        Iterator<String> argsIter = dumpContext.getArgsAsList().iterator();

        String command = ArgsHelper.nextOptionalArg(argsIter, null);

        if (COMMAND_SEED.equalsIgnoreCase(command)) {
            seedDb();
        } else if (COMMAND_DROP.equalsIgnoreCase(command)) {
            dropDb();
        } else {
            usage(dumpContext.getStdout());
            if (command != null) {
                throw new DumpUsageException("Unknown command: " + command);
            }
        }
    }

    private void seedDb() {
        createVariable("foo");
        createVariable("bar");
        createVariable("wibble");
        createVariable("wobble");
    }

    private void dropDb() {
        Delete.table(Variable.class);
    }

    private void createVariable(String name) {
        Variable var = new Variable();
        var.setName(name);
        var.setValue(injector.getRandom().nextInt(100));
        var.setRandomValue(injector.getRandom().nextInt());
        var.update();
    }

    private static void usage(PrintStream writer) {
        final String cmdName = "dumpapp " + PLUGIN_NAME;
        final String usagePrefix = "Usage: " + cmdName + " ";

        writer.println(usagePrefix + "<command> [command-options]");
        writer.print(usagePrefix + COMMAND_SEED);
        writer.println();
        writer.print(usagePrefix + COMMAND_DROP);
        writer.println();
    }

}
