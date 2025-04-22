# What are object relationships in Java?

####  In Java, object relationships like Association, Aggregation, and Composition define how objects are connected and interact in object-oriented programming. They help design real-world models in software.

⸻

#### What is Association in Java?

Association is a relationship where one object is connected to another, but they can exist independently. It’s also called a “uses-a” relationship.

🔹 Key Points:
•	No ownership between objects.
•	Both objects can exist independently.
•	Can be one-to-one, one-to-many, or many-to-many.

✅ Example:

A Teacher can teach multiple Students.
Even if a teacher is deleted, the students still exist.

⸻

#### What is Aggregation in Java?

Aggregation is a special form of association where one object has-a relationship with another but the parts can exist independently of the whole.

🔹 Key Points:
•	Weaker ownership.
•	“Has-a” relationship.
•	Contained object can exist independently.

✅ Example:

A Library contains Books.
If the library is deleted, the books can still exist.

⸻

#### What is Composition in Java?

Composition is a strong form of aggregation. One object owns another, and the lifetime of the part depends on the whole. It’s a “part-of” relationship.

🔹 Key Points:
•	Strong ownership.
•	If the container is destroyed, the part is destroyed.
•	Strong coupling.

✅ Example:

A House contains Rooms.
If the house is destroyed, the rooms no longer exist.