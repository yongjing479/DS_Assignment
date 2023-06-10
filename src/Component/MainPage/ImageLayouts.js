import React, { Component } from 'react';
import "./MainPage.css";



class ImageLayouts extends Component {
    constructor(props) {
        super(props);
        this.state = {  }
    }
    
    render() { 
        return ( 
            <div className="imageLayout_container">
                <div className="imageLayout_imglay">
                    <img className="imageLayout_img" src={this.props.image} />
                </div>
                <div className="imageLayout_text">
                    {this.props.text}
                </div>
            </div>
         );
    }
}
 
export default ImageLayouts;