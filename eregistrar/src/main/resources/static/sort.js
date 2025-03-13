document.addEventListener("DOMContentLoaded", function () {
    let sortDirections = {}; // Track sorting order for each column

    window.sortTable = function (colIndex) {
        let table = document.getElementById("studentTable");
        let rows = Array.from(table.getElementsByTagName("tbody")[0].rows);
        let header = table.rows[0].cells[colIndex];

        // Toggle sorting order (ascending/descending)
        let direction = sortDirections[colIndex] === "asc" ? "desc" : "asc";
        sortDirections[colIndex] = direction;

        // Sorting logic
        let sortedRows = rows.sort((a, b) => {
            let aText = a.cells[colIndex].innerText.trim();
            let bText = b.cells[colIndex].innerText.trim();

            // Convert numeric columns to numbers for sorting
            if (colIndex === 0 || colIndex === 5) {
                aText = parseFloat(aText) || 0;
                bText = parseFloat(bText) || 0;
            }

            return direction === "asc"
                ? aText.localeCompare(bText, undefined, { numeric: true })
                : bText.localeCompare(aText, undefined, { numeric: true });
        });

        // Update table with sorted rows
        table.getElementsByTagName("tbody")[0].append(...sortedRows);

        // Update sorting icons
        updateSortIcons(header, direction);
    };

    function updateSortIcons(header, direction) {
        // Reset all sorting icons
        document.querySelectorAll("th i").forEach(icon => {
            icon.classList.remove("fa-sort-up", "fa-sort-down");
            icon.classList.add("fa-sort");
        });

        // Set current sorting column icon
        let icon = header.querySelector("i");
        if (direction === "asc") {
            icon.classList.remove("fa-sort", "fa-sort-down");
            icon.classList.add("fa-sort-up");
        } else {
            icon.classList.remove("fa-sort", "fa-sort-up");
            icon.classList.add("fa-sort-down");
        }
    }
});
