public class HtmlPersonPrinter extends PersonPrinter{

	@Override
	public void printNames(Person[] items) {
		if (items != null) {
			System.out.println("<ul>");
			for (int i = 0; i <items.length; i ++) {
				System.out.println("<li>" + items[i].getName() + "</li>");
			}
			System.out.println("</ul>");
		}
		
	}

}
