addForm.addEventListener('submit', (event) => {

 event.preventDefault();// Prevent the form from submitting normally

 const title = document.querySelector('#title').value;
 const description = document.querySelector('#description').value;
 const date = document.querySelector('#date').value;

addTask(title,description,date);// Call the function to add the task

addFormModal.hide(); // Close the modal after the form is submitted


});
