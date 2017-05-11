package domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import model.HintLetter;

@RunWith(Suite.class)
@SuiteClasses({ PuntTest.class, SpelerTest.class, CirkelTest.class, RechthoekTest.class, LijnStukTest.class, DriehoekTest.class, /*HangmanTest.class,*/ HintLetter.class, HintWoordTest.class, OmhullendeTest.class, TekeningHangManTest.class, TekeningTest.class, WoordenLijstTest.class })
public class AllTests {

}
