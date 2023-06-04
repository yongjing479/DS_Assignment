import React from 'react';
import './HeaderArea.css'
//import {AiOutlineSearch, AiOutlineWallet, AiFillHome} from 'react-icons/ai'
//import{FaRegFlag, FaUsers, FaPlusCircle, FaFacebookMessenger, FaBell} from 'react-icons/fa'
//import {MdOndemandVideo} from 'react-icons/md'

function HeaderArea(){
    return(
        <div className="HomePage">
            <div className="header">
                <div className="first-header">
                    <div className="logo">
                    <img src="./images/sircleLogo.png" alt="logo" style={{height:"55px", padding:"1rem"}}/>

                    {/* </div>
                    <div className="Search">
                        <AiOutlineSearch style={{height:"4rem"}}/>
                        <input placeholder = "Search Sircle" yupe="Search"/>
                    </div>

                    
                </div>
                <div className="middle-header">
                    <div className="Icon">
                        <AiFillHome fontsize="2.3rem" color ="#1877F2"/>
                    </div>
                    <div className="Icon">
                        <FaRegFlag fontsize="2.3rem" />
                    </div>
                    <div className="Icon">
                        <MdOndemandVideo fontsize="2.3rem" />
                    </div>
                    <div className="Icon">
                        <FaUsers fontsize="2.3rem" />
                    </div>
                    <div className="Icon">
                        <AiOutlineWallet fontsize="2.3rem" />
                    </div>
                </div>
                <div className="third-header">
                    <div className="plus">
                        <FaPlusCircle fontsize = "2rem"/>
                    </div>
                    <div className="plus">
                        <FaFacebookMessenger fontsize = "2rem"/>
                    </div>
                    <div className="plus">
                        <FaBell fontsize = "2rem"/>
                    </div>
                    <div className="plus">
                        <img src="./images/dp1.png"/>
    </div>*/}
                    </div>
                </div>
            </div> 
            
        </div>
    )
}

export default HeaderArea;