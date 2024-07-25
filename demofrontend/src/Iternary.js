// src/LeafletMapComponent.js
import React, { useEffect } from 'react';
import { MapContainer, TileLayer } from 'react-leaflet';
import 'leaflet/dist/leaflet.css';
import L from 'leaflet';
import 'leaflet-routing-machine';

const LeafletMapComponent = ({ origin, destination }) => {
  useEffect(() => {
    if (!origin || !destination) return;

    const map = L.map('map').setView([37.7749, -122.4194], 13);

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
    }).addTo(map);

    L.Routing.control({
      waypoints: [
        L.latLng(37.7749, -122.4194), // San Francisco
        L.latLng(34.0522, -118.2437), // Los Angeles
      ],
      routeWhileDragging: true,
    }).addTo(map);

    return () => map.remove();
  }, [origin, destination]);

  return <div id="map" style={{ height: '400px', width: '75%', margin:'auto', zIndex:'100' }} />;
};

export default LeafletMapComponent;
