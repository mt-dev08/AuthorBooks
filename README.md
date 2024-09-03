<h2>Project Overview</h2>
<p>This backend project is built using Java Spring Boot, Spring Data JPA, and MySQL. It demonstrates a one-to-many relationship between <code>Author</code> and <code>Books</code> entities, where:</p>
<ul>
  <li>One <code>Author</code> can have multiple <code>Books</code>.</li>
  <li>Each <code>Book</code> is associated with only one <code>Author</code>.</li>
</ul>
<p>The project provides RESTful APIs to manage authors and books, including creating new authors and books, fetching all authors and books, and retrieving specific records by their IDs.</p>

<h2>Project Structure</h2>

<h3>1. Entities</h3>
<ul>
  <li><strong>Author</strong>: Represents an author with a one-to-many relationship with books.</li>
  <li><strong>Books</strong>: Represents individual books linked to a single author.</li>
</ul>

<h3>2. DTOs (Data Transfer Objects)</h3>
<ul>
  <li><code>AddAuthorRequestDto</code>: Used to create a new author along with their books.</li>
  <li><code>GetAllAuthorsResponseDto</code> and <code>GetAuthorResponseDto</code>: Used to retrieve author details.</li>
  <li><code>AddBooksRequestDto</code>: Used to create a new book.</li>
  <li><code>GetAllBooksResponseDto</code> and <code>GetBooksResponseDto</code>: Used to retrieve book details.</li>
</ul>

<h3>3. Services</h3>
<ul>
  <li><strong>AuthorService</strong>:
    <ul>
      <li><code>getAllAuthors()</code>: Fetches all authors along with their details.</li>
      <li><code>getAuthorById(Long id)</code>: Retrieves a specific author by their ID.</li>
      <li><code>createAuthor(AddAuthorRequestDto addAuthorRequestDto)</code>: Creates a new author and their associated books, saving them to the database.</li>
    </ul>
  </li>
  <li><strong>BooksService</strong>:
    <ul>
      <li><code>getAllBooks()</code>: Fetches all books along with their details.</li>
      <li><code>getBookById(Long id)</code>: Retrieves a specific book by its ID.</li>
      <li><code>createBook(AddBooksRequestDto addBooksRequestDto)</code>: Creates a new book and saves it to the database.</li>
    </ul>
  </li>
</ul>

<h3>4. Controllers</h3>
<ul>
  <li><strong>AuthorController</strong>:
    <ul>
      <li><code>createAuthor()</code>: Endpoint to create a new author along with their books.</li>
      <li><code>getById(Long id)</code>: Endpoint to fetch a specific author by ID.</li>
      <li><code>getAll()</code>: Endpoint to retrieve all authors.</li>
    </ul>
  </li>
  <li><strong>BooksController</strong>:
    <ul>
      <li><code>createBooks()</code>: Endpoint to create a new book.</li>
      <li><code>getById(Long id)</code>: Endpoint to fetch a specific book by ID.</li>
      <li><code>getAll()</code>: Endpoint to retrieve all books.</li>
    </ul>
  </li>
</ul>

<h2>Key Functionalities</h2>
<ul>
  <li><strong>Author Management</strong>:
    <ul>
      <li>Create a new author along with multiple books in a single request.</li>
      <li>Fetch all authors with their associated books.</li>
      <li>Retrieve individual author details by their ID.</li>
    </ul>
  </li>
  <li><strong>Books Management</strong>:
    <ul>
      <li>Create individual books and link them to an existing author.</li>
      <li>Fetch all books along with their details.</li>
      <li>Retrieve individual book details by their ID.</li>
    </ul>
  </li>
  <li><strong>Error Handling</strong>: Proper error handling is implemented using custom exceptions (e.g., <code>ResourceNotFound</code>) for cases when requested resources do not exist.</li>
</ul>

<h2>Technologies Used</h2>
<ul>
  <li><strong>Java Spring Boot</strong>: For building the backend RESTful APIs.</li>
  <li><strong>Spring Data JPA</strong>: For database interactions and ORM (Object-Relational Mapping).</li>
  <li><strong>MySQL</strong>: As the relational database to store authors and books.</li>
  <li><strong>Lombok</strong>: To reduce boilerplate code for data objects.</li>
</ul>

<h2>How to Run the Project</h2>
<ol>
  <li>Clone the repository.</li>
  <li>Set up the MySQL database and update the database connection details in <code>application.properties</code>.</li>
  <li>Run the application using your preferred IDE or command line:</li>
</ol>
<pre><code>mvn spring-boot:run</code></pre>
<p>Use Postman or any other API client to interact with the available endpoints.</p>

<h2>Endpoints</h2>
<ul>
  <li><strong>Author Endpoints</strong>:
    <ul>
      <li><code>POST /author/create</code>: Create a new author with books.</li>
      <li><code>GET /author/{id}</code>: Fetch an author by their ID.</li>
      <li><code>GET /author/all</code>: Fetch all authors.</li>
    </ul>
  </li>
  <li><strong>Book Endpoints</strong>:
    <ul>
      <li><code>POST /books/create</code>: Create a new book.</li>
      <li><code>GET /books/{id}</code>: Fetch a book by its ID.</li>
      <li><code>GET /books/all</code>: Fetch all books.</li>
    </ul>
  </li>
</ul>
