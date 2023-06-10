import React, { Component } from 'react';
import "./LeftSide.css";

class RecentLayout extends Component {
    constructor(props) {
        super(props);
    }
    state = {  }
    render() { 
        return ( 
        <div className='recentLayout_container'>
            <div className="recentLayout_imglay">
                    <img className="recentLayout_img" src={this.props.image} />
                </div>
                <div className="recentLayout_text">
                    {this.props.text}
                </div>
        </div>
         );
    }
}
 
export default RecentLayout;