package mathieu.pglp_4_2.command.generic;

import mathieu.pglp_4_2.command.Command;

/**
 * partie génrique des commandes pour quit/undo.
 */
public interface GenericCommand extends Command {
    /**
     * fonction du pattern command.
     */
    void apply();
}
