package snackVendingMachine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.VM.VM;

class TestVM {

	@BeforeEach
	void setUp() throws Exception {
	}

//
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

	@Test

	void change() {
		VM snack = new VM();
		Integer result = snack.dispenseChange();
		assertTrue(result.equals(0));
	}

	void verifyTheChange() {
		VM snack = new VM();
		Boolean result = snack.verifyIfChangeToReturn();
		assertTrue(result);
	}

	void verifyTheMoney() {
		VM snack = new VM();
		Boolean result = snack.verifyIfMoneyIsEnough();
		assertTrue(result);
	}
}
