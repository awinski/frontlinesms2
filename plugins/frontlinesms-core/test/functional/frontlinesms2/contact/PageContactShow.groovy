package frontlinesms2.contact

import frontlinesms2.*

class PageContactShow extends frontlinesms2.page.PageContact {
	static url = ''
	String convertToPath(Object [] args) {
		if (args.equals(null) || args.length == 0)
			return "contact/show"
		if (args[0] instanceof String) {
			def contactId = remote { Contact.findByName(args[0]).id }
			return "contact/show/${contactId}"
		}
		if (args[0] instanceof Group && args.length == 2)
			return "group/show/${(args[0] as Group).id}/contact/show/${(args[1] as Contact).id}"
		if (args[0] instanceof Group && args.length == 1)
			return "group/show/${(args[0] as Group).id}"
		if (args[0] instanceof Number || args[0] instanceof String)
			return "contact/show/${args[0]}"
	}

	static at = {
		title.contains('Contacts')
	}
}

class PageGroupShow extends PageContactShow {
	String convertToPath(Object [] args) {
		if (args.equals(null) || args.length == 0)
			return "contact/show"
		if (args[0] instanceof Number)
			return "group/show/${(args[0])}"
		if (args[0] instanceof Group && args.length == 2)
			return "group/show/${(args[0] as Group).id}/contact/show/${(args[1] as Contact).id}"
		if (args[0] instanceof Group && args.length == 1)
			return "group/show/${(args[0] as Group).id}"
	}
}

