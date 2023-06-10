import React, { useEffect, useState } from 'react';
import { Button, Modal, Input } from 'antd';
import { EyeTwoTone, EyeInvisibleOutlined, CheckCircleTwoTone } from '@ant-design/icons';
import './SignUp.css';
import DOB from './DatePicker';
import Gender from './Gender';

const SignUpModal = () => {
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [activeInput, setActiveInput] = useState('');
  const [password, setPassword] = useState('');
  const [retype_password, setRetypePassword] = useState('');
  const [error, setError] = useState(false);

  const handlePasswordChange = (e) => {
    const value = e.target.value;
    setPassword(value);

    const passwordRegex = /^(?=.*[A-Z])(?=.*\d).{8,}$/;
    const isValidPassword = passwordRegex.test(value);

    if (!isValidPassword) {
      setError(true);
    } else {
      setError(false);
    }

    setRetypePassword('');
  };

  const handleRetypePasswordChange = (e) => {
    const value = e.target.value;
    setRetypePassword(value);

    if (value !== password) {
      setError(true);
    } else {
      setError(false);
    }
  };

  const showModal = () => {
    setIsModalOpen(true);
  };

  const handleOk = () => {
    setIsModalOpen(false);
    Modal.info({
      title: 'Sign Up Successful',
      content: 'Please login to continue.',
      icon: <CheckCircleTwoTone twoToneColor="#52c41a" />,
      onOk: () => {},
    });
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
        type="green-6"
        onClick={showModal}
        style={{
          color: 'white',
          fontWeight: 'bold',
          fontSize: '17px',
          height: '20px',
          marginBottom: '10px',
          alignItems: 'center',
          background: 'transparent',
          border: 'none',
          transition: 'color 0.3s ease',
          marginLeft: '-10px',
          textAlign: 'left',
          width: '200px',
          lineHeight: '20px',
          padding: '5px 10px',
          display: 'inline-block',
        }}
        className="create-button"
      >
        Create New Account
      </Button>
      {isModalOpen && (
        <Modal
          title="Sign Up"
          visible={isModalOpen}
          onOk={handleOk}
          onCancel={handleCancel}
          okButtonProps={{ type: 'primary' }}
          okText="Sign Up"
        >
          <label>Username</label>
          <Input
            type="text"
            placeholder="Username"
            style={{
              height: '45px',
              borderRadius: '5px',
              marginBottom: '5px',
            }}
            onFocus={() => handleInputFocus('username')}
          />

          <label>Email address</label>
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

          <label>Phone number</label>
          <Input
            type="number"
          
            placeholder="Phone number"
            style=
            {{
              height: '45px',
              borderRadius: '5px',
              marginBottom: '10px',
            }}
            onFocus={() => handleInputFocus('phoneNumber')}
          />

          <label>Password</label>
          <Input.Password
            placeholder="Password"
            style={{ marginBottom: '10px' }}
            onChange={handlePasswordChange}
          />

          {error && retype_password.length === 0 && (
            <p style={{ color: 'red' }}>
              Password must be at least 8 characters long and contain at least one uppercase letter and one number.
            </p>
          )}

          <label>Retype Password</label>
          <Input.Password
            placeholder="Retype Password"
            iconRender={(visible) => (visible ? <EyeTwoTone /> : <EyeInvisibleOutlined />)}
            style={{ marginBottom: '10px' }}
            onChange={handleRetypePasswordChange}
          />

          {error && retype_password.length > 0 && (
            <p style={{ color: 'red' }}>Password does not match. Please type the same password.</p>
          )}

          <label>Date of Birth</label>
          <br />
          <DOB />

          <br />
          <label style={{ marginTop: '10px' }}>Gender</label>
          <br />
          <Gender />
        </Modal>
      )}
    </div>
  );
};

export default SignUpModal;

