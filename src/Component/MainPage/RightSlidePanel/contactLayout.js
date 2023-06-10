import React, { Component } from 'react';
import "./RightSlide.css";

class contactLayout extends Component {
    constructor(props) {
        super(props);
    }
    state = {  }
    render() { 
        return ( 
            <div className='right_acceptFriend'>
                <div className='right_friend'>
                    <img className='right_friendimg' src={this.props.image}/>
                </div>
            
                <div className='right_info'>
                    <div className='name' >{this.props.text}</div> 
                    <div className='mutual_friend' > {this.props.num}</div>
                </div>
            
            </div>
         );
    }
}
 
export default contactLayout;