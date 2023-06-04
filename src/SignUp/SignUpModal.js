
import React, { useState } from 'react';
import { Button, Modal, Input } from 'antd';
import { EyeInvisibleOutlined, EyeTwoTone } from '@ant-design/icons';
import './SignUp.css';

const SignUpModal = () => {
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [activeInput, setActiveInput] = useState('');

  const showModal = () => {
    setIsModalOpen(true);
  };

  const handleOk = () => {
    setIsModalOpen(false);
  };

  const handleCancel = () => {
    setIsModalOpen(false);
  };

  const handleInputFocus = (inputName) => {
    setActiveInput(inputName);
  };

  return (
    <div className="signupbutton">
      <Button
        title='create'
        type="green-6"
        onClick={showModal}
        style={{
          color: 'white',
          fontWeight: 'bold',
          fontSize: '17px',
          width: '100%',
          height: '20px',
          marginBottom: '10px',
          alignItems: 'center',      
          }}
      >
        Create New Account
      </Button>
      <Modal
        title="Sign Up"
        visible={isModalOpen}
        onOk={handleOk}
        onCancel={handleCancel}
        okButtonProps={{ type: 'primary' }}
        okText="Sign Up"
      >
        <Input
          type="text"
          placeholder="Username"
          style={{
            height: '45px',
            borderRadius: '5px',
            marginBottom: '10px',
          }}
          onFocus={() => handleInputFocus('username')}
        />

        <Input
          type="email"
          placeholder="Email"
          style={{
            height: '45px',
            borderRadius: '5px',
            marginBottom: '10px',
          }}
          onFocus={() => handleInputFocus('email')}
        />

        <Input
          type="number"
          placeholder="Phone number"
          style={{
            height: '45px',
            borderRadius: '5px',
            marginBottom: '10px',
          }}
          onFocus={() => handleInputFocus('phoneNumber')}
        />

        <Input.Password placeholder="Password" style={{ marginBottom: '10px' }} />

        <Input.Password
          placeholder="Retype Password"
          iconRender={(visible) => (visible ? <EyeTwoTone /> : <EyeInvisibleOutlined />)}
          style={{ marginBottom: '10px' }}
        />
      </Modal>
    </div>
  );
};

export default SignUpModal;