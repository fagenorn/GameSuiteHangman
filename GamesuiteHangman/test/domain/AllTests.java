package domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import model.HintLetter;
import ui.DrawTest;

@RunWith(Suite.class)
@SuiteClasses({DrawTest.class, PuntTest.class, SpelerTest.class, CirkelTest.class, RechthoekTest.class, LijnStukTest.class, DriehoekTest.class, HangmanTest.class, HintLetterTest.class, HintWoordTest.class, OmhullendeTest.class, TekeningHangManTest.class, TekeningTest.class, WoordenLijstTest.class })
public class AllTests {

}
