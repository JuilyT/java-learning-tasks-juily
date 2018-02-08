package org.Refactoring;

public class PrintStatementFactory {
	public static PrintStatement getStatement(PrintType printType, Customer customer) {
		switch (printType) {
			case EMAIL:
				return new EmailPrintStatement(customer);
			case PDF:
				return new PdfPrintStatement(customer);
			default:
				break;
		}
		return null;
	}
}

