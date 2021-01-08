import React, { useEffect, useState } from 'react';
import { fetchProducts } from '../api';
import OrderLocation from './OrderLocation';
import ProductsList from './ProductsList';
import StepsHeader from './StepsHeader';
import './style.css'
import { OrderLocationdata, Product } from './types';

function Olders(){
    const [orderLocation, setOrderLocation] = useState<OrderLocationdata>();
    const [products, setProducts] = useState<Product[]>([]);
    console.log(products)
    useEffect(() => {
      fetchProducts().then(response => setProducts(response.data))
      .catch(error => console.log(error))
    }, []);

    return (
      <div className="orders-container">
        <StepsHeader/>         
        <ProductsList products={products}/> 
        <OrderLocation onChangeLocation={location => setOrderLocation(location)}/>
      </div>
    )
}

export default Olders;