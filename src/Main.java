import net.sourceforge.gxl.GXLDocument;
import net.sourceforge.gxl.GXLGraph;


public class Main {
    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Provide file name to save.");
            return;
        }

        StableMarriage marriage = new StableMarriage(Mock.getWomen1(), Mock.getMen1());
        marriage.printPossibilities();
        marriage.connectPeople();
        System.out.println();
        marriage.printMarriages();

        GXLDocument gxlDocument = new GXLDocument();
        GXLGraph gxlGraph = marriage.asGraph();
        gxlDocument.getDocumentElement().add(gxlGraph);
        GXLManager.saveGXLDocument(gxlDocument, args[0]);
    }
}
