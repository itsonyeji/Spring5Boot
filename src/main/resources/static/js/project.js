//agree
let agree1= document.querySelector("#agree1");
let agree2= document.querySelector("#agree2");
let okagree= document.querySelector("#okagree");
let noagree= document.querySelector("#noagree");

okagree?.addEventListener('click', ()=> {
    if(!agree1.checked)  alert('이용약관에 동의에 체크하세요!');
    else if(!agree2.checked) alert('개인정보 이용 동의에 체크하세요!');
    else location.href='/join/checkme';
});
noagree?.addEventListener('click', ()=>{
    location.href="/";
});


// checkme
let frm=document.forms.agreefrm2;/*이 방법은 주소창에 정보가 다 나옴*/
let checkbtn2=document.querySelector('#checkbtn2');
let cancelbtn2=document.querySelector('#cancelbtn2');

checkbtn2?.addEventListener('click', ()=>{
    if(frm.name.value==='') alert('이름을 입력하세요!');
    else if(frm.jumin1.value==='') alert('주민번호를 입력하세요!');
    else if(frm.jumin2.value==='') alert('나머지 주민번호를 입력하세요!');
    else if(!frm.infoagree.checked) alert('주민등록번호 처리 동의에 체크하세요!');
    else {
        let params='?name=' +frm.name.value;    /*이 방법은 주소창에 정보가 다 나옴*/
        params +='&jumin1='+frm.jumin1.value;
        params +='&jumin2='+frm.jumin2.value;
        location.href = '/join/joinme'+params;
    }
});
cancelbtn2?.addEventListener('click', ()=>{
    location.href="/";
});