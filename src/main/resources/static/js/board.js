// board view
let newbdbtn=document.querySelector('#newbdbtn');
let modbdbtn = document.querySelector('#modbdbtn');
let rmvbdbtn = document.querySelector('#rmvbdbtn');
let lstbdbtn = document.querySelector('#lstbdbtn');
newbdbtn?.addEventListener('click', ()=>{
   location.href='/board/write';
});

modbdbtn?.addEventListener('click', ()=>{
    if(confirm("정말 수정하시겠어요?")){
        alert('아직 미지원 기능입니다.');
    }
    /*location.href='/board/modify';*/
})
rmvbdbtn?.addEventListener('click', ()=>{
    if(confirm("정말 삭제하시겠어요?")){
        alert('아직 미지원 기능입니다.');
    }
    //location.href='/board/remove';
})
lstbdbtn?.addEventListener('click', ()=>{
   location.href='/board/list/1';
});


// board write
let wrtbdbtn = document.querySelector("#wrtbdbtn");
let cancelbtn3 = document.querySelector("#cancelbtn3");
wrtbdbtn?.addEventListener('click', ()=>{
    let frm = document.forms.bdfrm;
    if(frm.title.value ==='') alert("제목을 입력하세요!");
    else if(frm.contents.value === '') alert("본문을 입력하세요!");
    else if(grecaptcha.getResponse() ==='') alert("자동쓰기방지를 체크하세요!");
    else{
       frm.method='post';
       frm.submit();
       alert('새글 등록이 완료되었습니다.');
    }
});
cancelbtn3?.addEventListener('click', ()=>{
    location.href="/board/list/1";
});

// board find
let findtype = document.querySelector('#findtype');
let findkey = document.querySelector('#findkey');
let findbtn=document.querySelector('#findbtn');
findbtn?.addEventListener('click', ()=>{
   if(findkey.value ==='') alert('검색어를 입력하세요!');
   else{
       location.href=`/board/find/${findtype.value}/${findkey.value}/1`;
   }
});



