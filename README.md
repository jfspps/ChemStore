# ChemStore

ChemStore is a chemical stock and inventory database, designed as a Java EE (REST) Web service. To access use `localhost:8080/api/` or from a browser `http://localhost:8080/api/chemstore`.

## JPA Entities

All JPA entities are extensions of AbstractEntity. The key entities stored permanently are:

+ Supplier
    + Company name
    + Contact email
    + Contact phone number
+ Reagent
    + CAS ID
    + Name
+ Apparatus
    + Name
    + Capacity
  
The stock items are then related to the supplier via one-to-one relational mappings:

+ StockChemical
    + Reagent
    + Supplier (one-to-one)
    + Unit (enum)
    + Expiry Date
    + Density
    + Concentration
+ StockApparatus
    + Apparatus
    + Supplier (one-to-one)

With the above records put in place, the end-user will eventually be expected to keep a record of current stock:

+ Chemical stock
    - StockChemical (one-to-one)
    - Quantity
+ Apparatus stock
    - StockApparatus (one-to-one)
    - Quantity

The shopping lists can be mapped to the current stock (when transferring the order to "package received", the service 
will either update current inventories or build new entities)

+ Reagent shopping list
    - Supplier
    - CAS ID
    - Unit mass/volume
    - Quantity required
    - Price per unit
    - Currency (enum)
    - OUTPUT: total cost
+ Apparatus shopping list
    - Supplier
    - Name
    - Capacity

The teacher can submit a request sheet for a class, for classes taking the same experiment, saving the instructions for
future use:

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

The school/college technician can also make use of a reagent quantities calculator:

+ School technician reagent quantities and dilutions calculator
  - Molar/formula mass
  - Stock concentration
  - Volume per student
  - Number of students + surplus
  - OUTPUT: volume/mass required