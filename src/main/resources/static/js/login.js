// login
let loginbtn = document.querySelector("#loginbtn");
let lguid = document.querySelector("#userid");
let lgpwd = document.querySelector("#passwd");
let lgfrm = document.querySelector('#lgnfrm');

loginbtn?.addEventListener('click', ()=>{
    if(lguid.value=='')  alert('아이디를 입력하세요!');
    else if(lgpwd.value=='')  alert('비밀번호를 입력하세요!');
    else{
        lgfrm.method='post';
        lgfrm.action='/join/login'
        lgfrm.submit();
    }
});

// logout
let lgoutbtn = document.querySelector('#lgoutbtn');

lgoutbtn?.addEventListener('click', ()=>{
    location.href='/join/logout';
});
