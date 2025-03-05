import React, { useState } from "react";
import CarCard from "../components/CarCard";
import Sidebar from "../components/Sidebar";
import "../styles/SearchPage.css";

const SearchPage = () => {
    const mockCars = [
        { id: 1, brand: "Toyota", model: "Corolla", year: 2022, type: "Sedan", seats: 5, price_per_day: 50, image_url: "https://source.unsplash.com/300x200/?toyota,corolla" },
        { id: 2, brand: "Honda", model: "Civic", year: 2021, type: "Sedan", seats: 5, price_per_day: 45, image_url: "https://source.unsplash.com/300x200/?honda,civic" },
        { id: 3, brand: "Ford", model: "Mustang", year: 2023, type: "Sports", seats: 4, price_per_day: 90, image_url: "https://source.unsplash.com/300x200/?ford,mustang" },
        { id: 4, brand: "BMW", model: "X5", year: 2022, type: "SUV", seats: 5, price_per_day: 120, image_url: "https://source.unsplash.com/300x200/?bmw,x5" },
        { id: 5, brand: "Mercedes", model: "E-Class", year: 2022, type: "Luxury", seats: 5, price_per_day: 150, image_url: "https://source.unsplash.com/300x200/?mercedes,e-class" },
        { id: 6, brand: "Audi", model: "Q7", year: 2023, type: "SUV", seats: 7, price_per_day: 140, image_url: "https://source.unsplash.com/300x200/?audi,q7" },
        { id: 7, brand: "Tesla", model: "Model 3", year: 2023, type: "Electric", seats: 5, price_per_day: 100, image_url: "https://source.unsplash.com/300x200/?tesla,model3" },
        { id: 8, brand: "Chevrolet", model: "Camaro", year: 2022, type: "Sports", seats: 4, price_per_day: 85, image_url: "https://source.unsplash.com/300x200/?chevrolet,camaro" },
        { id: 9, brand: "Hyundai", model: "Elantra", year: 2021, type: "Sedan", seats: 5, price_per_day: 40, image_url: "https://source.unsplash.com/300x200/?hyundai,elantra" },
        { id: 10, brand: "Nissan", model: "Altima", year: 2021, type: "Sedan", seats: 5, price_per_day: 42, image_url: "https://source.unsplash.com/300x200/?nissan,altima" }
    ];

    const [cars, setCars] = useState(mockCars);
    const [filteredCars, setFilteredCars] = useState(mockCars);

    return (
        <div className="container">
            {/* Search Header */}
            <header className="search-header">
                <h1>Find Your Perfect Car Rental</h1>
                <form className="search-form">
                    <input type="text" placeholder="Pick-up Location" />
                    <input type="text" placeholder="Drop-off Location" />
                    <input type="date" />
                    <input type="time" />
                    <input type="date" />
                    <input type="time" />
                    <button type="submit">Search</button>
                </form>
            </header>

            {/* Sidebar + Car List Container */}
            <div className="main-content">
                <Sidebar cars={cars} setFilteredCars={setFilteredCars} />
                <div className="car-list">
                    {filteredCars.length > 0 ? (
                        filteredCars.map((car) => <CarCard key={car.id} car={car} />)
                    ) : (
                        <p className="no-results">No cars available for selected filters.</p>
                    )}
                </div>
            </div>
        </div>
    );
};

export default SearchPage;
