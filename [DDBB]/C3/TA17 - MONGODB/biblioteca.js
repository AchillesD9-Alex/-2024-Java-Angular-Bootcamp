use biblioteca

// Insertar documento 1
db.libros.insertOne({
    "Titulo": "Moby Dick",
    "Fecha_lanzamiento": "1851",
    "Autor": "Herman Melville",
    "Categoria": "Novela de aventuras",
    "Editorial": "Richard Bentley",
    "Idioma": "Inglés",
    "Páginas": 624,
    "Descripción": "Moby Dick es una novela épica de Herman Melville que sigue la obsesión del capitán Ahab por vengarse de Moby Dick, un enorme cachalote blanco que le arrancó una pierna en un encuentro anterior. La historia es una reflexión sobre la obsesión, la naturaleza humana y el destino.",
    "Portada": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8b/Herman_Melville_by_Joseph_Oriel_Eaton%2C_c1850-1855.jpg/220px-Herman_Melville_by_Joseph_Oriel_Eaton%2C_c1850-1855.jpg"
});

// Insertar documento 2
db.libros.insertOne({
    "Titulo": "1984",
    "Fecha_lanzamiento": "1949",
    "Autor": "George Orwell",
    "Categoria": "Distopía",
    "Editorial": "Secker & Warburg",
    "Idioma": "Inglés",
    "Páginas": 328,
    "Descripción": "1984 es una novela distópica de George Orwell que presenta un mundo totalitario gobernado por un partido político omnipresente liderado por el Gran Hermano. La novela explora temas como la vigilancia, la manipulación de la verdad y la libertad individual.",
    "Portada": "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/1984first.jpg/220px-1984first.jpg"
});

// Insertar documento 3
db.libros.insertOne({
    "Titulo": "Don Quijote de la Mancha",
    "Fecha_lanzamiento": "1605",
    "Autor": "Miguel de Cervantes",
    "Categoria": "Novela picaresca",
    "Editorial": "Francisco de Robles",
    "Idioma": "Español",
    "Páginas": 863,
    "Descripción": "Don Quijote de la Mancha es una obra maestra de Miguel de Cervantes que narra las aventuras de un hidalgo enloquecido que decide convertirse en caballero andante. La novela es una sátira de la sociedad y la literatura de la época, y ha sido aclamada como una de las mejores obras de la literatura universal.",
    "Portada": "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/Don_Quijote_%281609%29.jpg/220px-Don_Quijote_%281609%29.jpg"
});

// Insertar documento 4
db.libros.insertOne({
    "Titulo": "Harry Potter y la piedra filosofal",
    "Fecha_lanzamiento": "1997",
    "Autor": "J.K. Rowling",
    "Categoria": "Fantasía",
    "Editorial": "Bloomsbury Publishing",
    "Idioma": "Inglés",
    "Páginas": 223,
    "Descripción": "Harry Potter y la piedra filosofal es el primer libro de la serie de Harry Potter de J.K. Rowling. Narra las aventuras de Harry Potter, un niño mago que descubre su verdadera identidad en su undécimo cumpleaños. La historia sigue su viaje en el mundo mágico mientras asiste a la escuela de magia Hogwarts.",
    "Portada": "https://upload.wikimedia.org/wikipedia/en/b/bf/Harry_Potter_and_the_Philosopher%27s_Stone_Jacket.jpg"
});

// Insertar documento 5
db.libros.insertOne({
    "Titulo": "Orgullo y prejuicio",
    "Fecha_lanzamiento": "1813",
    "Autor": "Jane Austen",
    "Categoria": "Novela romántica",
    "Editorial": "T. Egerton, Whitehall",
    "Idioma": "Inglés",
    "Páginas": 279,
    "Descripción": "Orgullo y prejuicio es una novela romántica de Jane Austen que sigue las vidas de las hermanas Bennet y su búsqueda de amor y matrimonio en la Inglaterra rural del siglo XIX. La historia está llena de humor, ironía y observaciones agudas sobre la sociedad de la época.",
    "Portada": "https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/PrideAndPrejudiceTitlePage.jpg/220px-PrideAndPrejudiceTitlePage.jpg"
});
