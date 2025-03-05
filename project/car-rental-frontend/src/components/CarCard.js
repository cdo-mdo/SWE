import React from "react";
import "../styles/CarCard.css"; // Add styling for better layout

const CarCard = ({ car }) => {
    return (
        <div className="car-card">
            <img src={car.image_url} alt={`${car.brand} ${car.model}`} />
            <div className="car-details">
                <h3>{car.brand} {car.model} ({car.year})</h3>
                <p>Type: {car.type}</p>
                <p>Seats: {car.seats}</p>
                <p>Transmission: {car.transmission}</p>
                <p>Fuel: {car.fuel_type}</p>
                <h4>${car.price_per_day} / day</h4>
                <button className="rent-btn">Rent Now</button>
            </div>
        </div>
    );
};

export default CarCard;
