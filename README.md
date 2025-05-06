# Contact-Manager
A Contact Manager is a Java console application for storing and managing contact information locally. It simulates a lightweight database by using a text file to save details like first name, last name, email, phone number, and category (e.g., family, friends, work).


---

## 📦 Features

- ✅ Add a new contact  
- ✅ Read a contact by email  
- ✅ Delete a contact by first name  
- 📂 All data stored in `contact.txt` in a structured, readable format  
- ☕ Console-based interface  

---

## 📌 How It Works

Each contact is stored in the file with the following line-by-line structure:
@FirstName
!LastName
#Email
%PhoneNumber
$Category
--- (line seperator)

The system uses character tags (`@`, `!`, `#`, `%`, `$`) to identify each field.

---

## 🔧 Technologies

- Java  
- File I/O (BufferedReader / BufferedWriter)  
- ArrayList for dynamic data management  

---

## 🛠 To Do / Improve

- Add encryption for email or phone number  
- Add search by name or phone  
- Add update functionality  
- Build graphical user interface (GUI)  
- Implement file backup or autosave  

---

## 🚀 Getting Started

1. Copy all Java files into a folder named `contactmanager`.
2. Run `Main.java` to start the program.

Make sure `contact.txt` is in the same folder or let the program create it automatically.

---

## 📁 Structure

```
contactmanager/
├── Main.java
├── ContactManager.java
└── contact.txt
```


---

## 🌟 Contribution

Feel free to fork the repo and improve the functionality — like implementing encryption or extending the interface. This is a great project for those learning file handling, user input, and collection management in Java.

---

## © License

This project is open source and free to use.

