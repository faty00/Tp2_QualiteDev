//
// Utilisation nominale des classes td3.Buffer, Killring et td3.Editor
//
////////////////////////////////////////////////////////////////

import fr.einfolearning.tp2.metiers.EmacsKillRing;
import fr.einfolearning.tp2.metiers.TextBuffer;
import fr.einfolearning.tp2.metiers.TextEditor;
import fr.einfolearning.tp2.metiers.exceptions.EmacsKillRingOverflowException;

public class App {

    public static void scenarioEmacsKillRing() throws EmacsKillRingOverflowException {
        System.out.println("============ Test de la classe EmacsKillRing ============");
        EmacsKillRing emacsKillRing = new EmacsKillRing();
        //emacsKillRing.currentElt();
        System.out.println("Est-ce que le block est vide: " + (emacsKillRing.isEmpty()? "Oui" : "Non"));
        System.out.println("## Ajout du text: 'toto'");
        emacsKillRing.add("toto");
        System.out.println("## Ajout du text: 'koko'");
        emacsKillRing.add("koko");
        System.out.println("Est-ce que le block est vide: " + (emacsKillRing.isEmpty()? "Oui" : "Non"));
        System.out.println("## Valeur qui existe dans le block: " + emacsKillRing.toString());
    }
    public static void scenarioTextEditorCouperCollerYank() throws EmacsKillRingOverflowException, IllegalAccessException {
        TextEditor textEditor = new TextEditor("Ikram BAKACH je m'appelle  ");
        //couper
        textEditor.setCursor(0); textEditor.setMark(13);
        textEditor.killSection();
        System.out.println(textEditor.getBuffer());
        System.out.println(textEditor.getTextBuffer());
        //coller
        textEditor.setCursor(12);
        textEditor.yank();
        System.out.println(textEditor.getTextBuffer());
    }
    public static void scenarioTextEditorCopierCollerYank() throws IllegalAccessException, EmacsKillRingOverflowException {
        TextEditor textEditor = new TextEditor("Le mot doit être afficher 2 fois: Ikram ");
        System.out.println(textEditor.getTextBuffer());
        //copier
        textEditor.setCursor(33); textEditor.setMark(39);
        textEditor.killRingBackup();
        System.out.println(textEditor.getBuffer());
        //coller
        textEditor.setCursor(39);
        textEditor.yank();
        System.out.println(textEditor.getTextBuffer());
    }
    public static void scenarioTextEditorCopierCollerYankPop() throws IllegalAccessException, EmacsKillRingOverflowException {
        TextEditor textEditor = new TextEditor("BAKACH IKRAM je m'appelle  ");
        //copier1
        textEditor.setCursor(0); textEditor.setMark(12);
        textEditor.killRingBackup();
        System.out.println(textEditor.getBuffer());
        //copier2
        textEditor.setCursor(7); textEditor.setMark(12);
        textEditor.killRingBackup();
        System.out.println(textEditor.getBuffer());
        //coller
        textEditor.setCursor(26);
        textEditor.yank();
        textEditor.yankPop();
        System.out.println(textEditor.getBuffer());
        System.out.println(textEditor.getTextBuffer());

    }
    public static void scenarioTextEditorCouperCollerYankPop() throws IllegalAccessException, EmacsKillRingOverflowException {
        TextEditor textEditor = new TextEditor("BAKACH IKRAM je m'appelle  ");
        //copier1
        textEditor.setCursor(0); textEditor.setMark(12);
        textEditor.killSection();
        System.out.println(textEditor.getBuffer());
        //copier2
        textEditor.setCursor(7); textEditor.setMark(12);
        textEditor.killRingBackup();
        System.out.println(textEditor.getBuffer());
        //coller
        textEditor.setCursor(14);
        textEditor.yank();
        textEditor.yankPop();
        System.out.println(textEditor.getBuffer());
        System.out.println(textEditor.getTextBuffer());

    }

    public static void scenarioTextBuffer() throws EmacsKillRingOverflowException, IllegalAccessException {
        TextBuffer textBuffer = new TextBuffer("je suis ikram");
        //Insertion
        textBuffer.ins("Bonjour ",0);
        System.out.println(textBuffer.toString());

        //Suppression
        textBuffer.del(0,8);
        System.out.println(textBuffer.toString());

        //Capacité maximal du buffer
        int max = textBuffer.maxP();
        System.out.println(max);
    }

    public static void main(String[] args) throws EmacsKillRingOverflowException, IllegalAccessException {
        scenarioEmacsKillRing();
        scenarioTextEditorCouperCollerYank();
        scenarioTextEditorCouperCollerYankPop();
        scenarioTextEditorCopierCollerYank();
        scenarioTextEditorCopierCollerYankPop();
        scenarioTextBuffer();


    }
}
