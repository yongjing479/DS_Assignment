import React, { Component } from 'react';
import "./RightSlide.css";
import ImageLayouts from '../ImageLayouts';
import profilePic from "../../../images/dp4.png";
import covid from "../../../images/dp6.png";
import groups from "../../../images/dp1.png";
import memories from "../../../images/dp8.png";
import recent from "../../../images/dp2.png";
import saved from "../../../images/dp3.png";
import messenger from "../../../images/dp5.png";
import confirm from "../../../images/confirm.png";
import deleteb from "../../../images/delete.png";
import ContactLayout from './contactLayout';


class RightSlide extends Component {
    constructor(props) {
        super(props);
    }
    state = { 
        data:[]
     }
    
     getData=() => {
        let jsondata =[
            {
                "image":profilePic,
                "text":"Andy",
                "num": "mutual friends 3"
            },
            {
                "image":covid,
                "text":"Bendy",
                "num": "mutual friends 2"
            },
            {
                "image":groups,
                "text":"Candy",
                "num": "mutual friends 6"
            },
            {
                "image":memories,
                "text":"Diskson",
                "num": "mutual friends 4"
            },
            {
                "image":recent,
                "text":"Elna",
                "num": "mutual friends 8"
            },
            
        ];
        this.setState({data : jsondata});
    }

    componentDidMount(){
        this.getData();
    }

    render() { 
        return ( 
            <div className='rightside_container'>
                <div className='right_acceptFriend'>
                    <div className='right_friend'>
                        <img className='right_friendimg' src={profilePic}/>
                    </div>
                    
                    <div className='right_info'>
                        <div className='name' >Andy</div> 
                        <div className='mutual_friend' > mutual&nbsp;friends&nbsp;5</div>
                    </div>
                    <div className='right_accpetDecline'>
                        <img src ={confirm} width='100px' height='50px'/>
                        <img className='deleteIcon' src={deleteb} width='100px' height='50px'/>
                        <div className='show'>show&nbsp;more</div>
                        <div className='line' />
                    </div>
                    
                </div>
                
                <div className='rightside_header'>
                    Contacts
                </div>
                <div className='rightside_acceptFriend'>
                    {
                        this.state.data.map( (item) =>(
                        <ContactLayout image={item.image} text={item.text} num={item.num}/>
                        ))
                    } 
                </div>
            </div>
         );
    }
}
 
export default RightSlide;