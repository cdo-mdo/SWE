// Global variables for pagination and sorting
let currentPage = 0;
let currentSortBy = "studentId"; // Default sorting column
let currentSortDirection = "asc"; // Default sorting order

document.addEventListener("DOMContentLoaded", () => {
    const searchBox = document.getElementById("searchBox");
    const studentTableBody = document.getElementById("studentTableBody");

    // Search event listener
    searchBox.addEventListener("input", searchStudents);

    // Click event listener for inline editing
    studentTableBody.addEventListener("click", (event) => {
        let cell = event.target;
        if (cell.tagName === "TD" && !cell.classList.contains("no-edit")) {
            enableCellEditing(cell);
        }
    });

    // Initial student data load
    searchStudents();
});

// Fetch students from backend API
const searchStudents = () => {
    let keyword = document.getElementById("searchBox").value.trim();
    let url = `/api/students/search?keyword=${encodeURIComponent(keyword)}&page=${currentPage}&size=10&sortBy=${currentSortBy}&sortDirection=${currentSortDirection}`;

    fetch(url)
        .then(response => response.json())
        .then(data => {
            displayStudents(data.content);
            updatePagination(data);
        })
        .catch(error => console.error("Error fetching data:", error));
};

// Display students in the table
const displayStudents = (students) => {
    const tableBody = document.getElementById("studentTableBody");
    tableBody.innerHTML = ""; // Clear table

    students.forEach(student => {
        let row = `<tr data-id="${student.studentId}">
            <td>${student.studentId}</td>
            <td>${student.studentNumber}</td>
            <td>${student.firstName}</td>
            <td>${student.middleName || ""}</td>
            <td>${student.lastName}</td>
            <td>${student.cgpa ? student.cgpa.toFixed(2) : ""}</td>
            <td>${student.enrollmentDate}</td>
            <td>${student.isInternational ? 'Yes' : 'No'}</td>
            <td class="no-edit">
                <button class="btn btn-danger btn-sm" onclick="deleteStudent(${student.studentId})">
                    <i class="fas fa-trash-alt"></i>
                </button>
            </td>
        </tr>`;
        tableBody.innerHTML += row;
    });
};

// Sorting functionality
const sortTable = (colIndex, sortField) => {
    currentSortBy = sortField;
    currentSortDirection = currentSortDirection === "asc" ? "desc" : "asc";

    searchStudents();

    // Highlight sorted column
    document.querySelectorAll("th").forEach(th => th.classList.remove("sorted-asc", "sorted-desc"));
    let header = document.getElementById("studentTable").rows[0].cells[colIndex];
    header.classList.add(currentSortDirection === "asc" ? "sorted-asc" : "sorted-desc");
};

// Update pagination controls
const updatePagination = (data) => {
    let prevButton = document.getElementById("prevButton");
    let nextButton = document.getElementById("nextButton");

    if (prevButton && nextButton) {  // ✅ Only update if elements exist
        prevButton.disabled = data.first;
        nextButton.disabled = data.last;
    } else {
        console.error("Pagination buttons not found!");
    }

    document.getElementById("pageNumber").innerText = data.number + 1;
};

// Pagination controls
const prevPage = () => {
    if (currentPage > 0) {
        currentPage--;
        searchStudents();
    }
};

const nextPage = () => {
    if (!document.getElementById("nextButton").disabled) {
        currentPage++;
        searchStudents();
    }
};

// Delete a student
const deleteStudent = (studentId) => {
    if (!confirm("Are you sure you want to delete this student?")) return;

    fetch(`/api/students/delete/${studentId}`, { method: "DELETE" })
        .then(response => {
            if (response.ok) {
                alert("Student deleted successfully!");
                searchStudents(); // Refresh the table
            } else {
                throw new Error("Failed to delete student.");
            }
        })
        .catch(error => alert(error.message));
};

// Enable inline editing
const enableCellEditing = (cell) => {
    let oldValue = cell.innerText;
    let input = document.createElement("input");
    input.type = "text";
    input.value = oldValue;
    input.classList.add("form-control");
    cell.innerHTML = "";
    cell.appendChild(input);
    input.focus();

    input.addEventListener("keydown", (event) => {
        if (event.key === "Enter") {
            let newValue = input.value;
            let row = cell.parentElement;
            let studentId = row.dataset.id;
            let columnIndex = cell.cellIndex;
            updateStudent(studentId, columnIndex, newValue, cell);
        } else if (event.key === "Escape") {
            cell.innerHTML = oldValue; // Restore old value
        }
    });

    input.addEventListener("blur", () => cell.innerHTML = oldValue);
};

// Update student details
const updateStudent = (studentId, columnIndex, newValue, cell) => {
    const columnNames = ["studentNumber", "firstName", "middleName", "lastName", "cgpa", "enrollmentDate", "isInternational"];
    let columnName = columnNames[columnIndex - 1];

    fetch(`/api/students/update`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ studentId, columnName, value: newValue }),
    })
        .then(response => {
            if (!response.ok) throw new Error("Failed to update student.");
            return response.json();
        })
        .then(() => searchStudents()) // Fetch updated data from backend
        .catch(error => {
            alert(error.message);
            cell.innerHTML = newValue; // Show new value even if update fails
        });
};
