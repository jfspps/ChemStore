# ChemStore

ChemStore is a chemical stock and inventory database. Listed below are some of the key planned features:

The key records stored permanently:
+ Supplier
	+ Company name
	+ Contact email
	+ Contact phone number
+ Chemical reagent register (save permanently for future recall)
	+ CAS ID
	+ Name
	+ Unit (enum)
	+ Supplier
+ Apparatus register (save permanently for future recall)
	+ Name
	+ Capacity

The records pertaining to current stock
+ Chemical stock (enter CAS and autofill if on file)
	- CAS ID (name is automatically filled if on file)
	- Name
	- Unit of measure
	- Quantity
+ School technician reagent quantities and dilutions calculator
	- Molar/formula mass
	- Stock concentration
	- Volume per student
	- Number of students + surplus
	- OUTPUT: volume/mass required

The shopping lists can be mapped to the current stock (transfer to package receive, make changes as appropriate and then click save)
+ Reagent shopping list
	- Supplier
	- CAS ID
	- Stock mass/volume
	- Quantity required
	- Price per unit
	- Currency (enum)
	- OUTPUT: total cost
+ Apparatus shopping list
	- Supplier
	- Name
	- Capacity

The teacher can submit a request sheet for a class, for classes taking the same experiment, saving the instructions for future use:
+ Teacher chemical request facility
	- Date of request
	- Date/week of experiment(s)
	- Number of students
	- Number of surplus quantities
	- Chemicals required (name and quantity per student)
		+ Chemical name
		+ Quantity per student
	- Apparatus required (name and optionally capacity)
		+ Apparatus name
    + Quantity per student
