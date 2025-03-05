import React, { useState } from "react";
import "../styles/Sidebar.css";

const Sidebar = ({ cars, setFilteredCars }) => {
    const [filters, setFilters] = useState({
        type: "",
        min_price: "",
        max_price: ""
    });

    const applyFilters = () => {
        let filtered = cars;
        if (filters.type) filtered = filtered.filter(car => car.type === filters.type);
        if (filters.min_price) filtered = filtered.filter(car => car.price_per_day >= filters.min_price);
        if (filters.max_price) filtered = filtered.filter(car => car.price_per_day <= filters.max_price);
        setFilteredCars(filtered);
    };

    return (
        <aside className="sidebar">
            <h3>Filter</h3>
            <select onChange={(e) => setFilters({...filters, type: e.target.value})}>
                <option value="">All Types</option>
                <option value="Sedan">Sedan</option>
                <option value="SUV">SUV</option>
                <option value="Sports">Sports</option>
                <option value="Luxury">Luxury</option>
                <option value="Electric">Electric</option>
            </select>
            <input type="number" placeholder="Min Price" onChange={(e) => setFilters({...filters, min_price: e.target.value})} />
            <input type="number" placeholder="Max Price" onChange={(e) => setFilters({...filters, max_price: e.target.value})} />
            <button onClick={applyFilters}>Apply</button>
        </aside>
    );
};

export default Sidebar;
