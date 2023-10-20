    let containers = document.querySelectorAll('.main-item-container');
    let hearts = document.querySelectorAll('.heartcheck');
    let heartCheck = true;
    const token = localStorage.getItem('token');


    document.addEventListener('DOMContentLoaded', function() {
        console.log('DOM이 로드되었습니다.');

        showMain()
        let includes = document.querySelectorAll('[data-include]');
        Array.prototype.forEach.call(includes, function (element) {
            let path = element.getAttribute('data-include');
            fetch(path)
                .then(response => response.text())
                .then(data => {
                    element.innerHTML = data;
                    initializeEventHandlers(element);
                });
        });

        document.getElementById('main-items-container').addEventListener('click', function(event) {
            if (event.target.classList.contains('heartcheck')) {
                toggleHeart(event.target);
            }
        });

        updateContainersAndHearts();

        if (heartCheck) {
            hearts.forEach(singleHeart => {
                singleHeart.classList.remove("fa-heart");
                singleHeart.classList.add("fa-heart-o");
            });
        } else {
            hearts.forEach(singleHeart => {
                singleHeart.classList.add("fa-heart");
                singleHeart.classList.remove("fa-heart-o");
            });
        }



        // 버튼 클릭 이벤트 처리는 여기서 바로 설정
        let button = document.getElementById('login-button');
        if (token) {
            let loginChefName = document.getElementById("main-aside-login-username");
            let loginChefImg = document.getElementById("main-aside-login-img-id");
            let loginChefText = document.getElementById("main-aside-login-overview");

            toggleItems();

            fetch('http://localhost:8080/api/user/getUserInfo', {
                headers: {
                    'Authorization': 'Bearer ' + token
                }
            })
                .then(response => {
                    // 유효하지 않은 토큰에 대한 서버 응답을 확인
                    if (!response.ok) {
                        throw new Error('Invalid Token');
                    }
                    return response.json();
                })
                .then(data => {
                    // 데이터에서 값을 추출합니다.
                    let chefName = data.data.chefName;
                    let chefDetial = data.data.chefDetial;
                    let chefImgUrl = data.data.chefImgUrl;

                    // 값들을 DOM 요소에 할당합니다.
                    loginChefName.textContent = chefName;
                    loginChefText.textContent = chefDetial;
                    loginChefImg.src = chefImgUrl;
                })
                .catch(error => {
                    console.error('There was an error!', error);
                });
        } else{
            toggleItems();
        }


    });

    function logout(){
        let logoutA = document.getElementById("logout-a");
        fetch('http://localhost:8080/api/user/logout', {
            method: 'POST',
            headers: {
                'Authorization': 'Bearer ' + token
            }
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Failed to logout. Server responded with: ' + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                // 로그아웃 성공 후 토큰 삭제
                localStorage.removeItem('token');
                // 추가적인 로그아웃 후 처리 로직
                alert('Successfully logged out!');
                toggleItems();
                logoutA.href = "/main";
            })
            .catch(error => {
                console.error('There was an error!', error);
            });
    }
    const menuItems = document.querySelectorAll('.nav_menu_item');
    menuItems.forEach(item => {
        item.addEventListener('click', function(event) {
            event.preventDefault();  // 기본 앵커 클릭 동작 방지
            const type = this.getAttribute('data-type') || 'S';
            showMain(type);
        });
    });

    // 메인페이지 조회
    function showMain(type = 'S') {
        fetch(`http://localhost:8080/api/receipe/read/${type}/all`, {
            method: 'GET'
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Failed Server responded with: ' + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                console.log(data.data);



                // 받아온 데이터를 사용하여 HTML에 표시하기
                const mainItemsContainer = document.getElementById("main-items-container");

                // 기존에 있는 레시피 요소들을 초기화합니다.
                mainItemsContainer.innerHTML = "";

                data.data.forEach(receipe => {
                    // 각 레시피 항목에 대한 HTML 요소 생성하기
                    const receipeDiv = document.createElement("div");
                    receipeDiv.className = "main-item-container";

                    const imgDiv = document.createElement("div");
                    imgDiv.className = "main-item-img";

                    const img = document.createElement("img");
                    img.src = receipe.imgUrl;
                    img.alt = receipe.title;

                    imgDiv.appendChild(img);

                    const textDiv = document.createElement("div");
                    textDiv.className = "main-item-text";

                    const heartDiv = document.createElement("div");
                    heartDiv.className = "heart";

                    const iTag = document.createElement("i");
                    iTag.className = "heartcheck fa fa-heart";
                    iTag.setAttribute("aria-hidden", "true");

                    heartDiv.appendChild(iTag);

                    const titleDiv = document.createElement("div");
                    titleDiv.className = "main-item-title";
                    titleDiv.innerHTML = `<p>${receipe.title}</p>`;

                    const categoryDiv = document.createElement("div");
                    categoryDiv.className = "main-item-category";
                    categoryDiv.innerHTML = "<p>카테고리</p>"; // 카테고리 정보가 응답에 없으므로 임시 텍스트로 설정

                    const recipeDiv = document.createElement("div");
                    recipeDiv.className = "lmain-item-recipe";
                    recipeDiv.innerHTML = `<p>${receipe.introduce}</p>`;

                    const chefDiv = document.createElement("div");
                    chefDiv.className = "main-item-chef";
                    chefDiv.innerHTML = `<p>${receipe.chefName}</p>`;

                    textDiv.appendChild(heartDiv);
                    textDiv.appendChild(titleDiv);
                    textDiv.appendChild(categoryDiv);
                    textDiv.appendChild(recipeDiv);
                    textDiv.appendChild(chefDiv);

                    receipeDiv.appendChild(imgDiv);
                    receipeDiv.appendChild(textDiv);

                    mainItemsContainer.appendChild(receipeDiv);


                });
                updateContainersAndHearts();
                toggleItems();
            })
            .catch(error => {
                console.error('There was an error!', error);
            });


    }


    function initializeEventHandlers(element) {
        if (element.querySelectorAll('.main-item-container').length > 0) {
            toggleItems();
        }
        updateContainersAndHearts();
    }

        function toggleItems() {
            let mainAsideLogin = document.getElementById('main-aside-login-html');
            let mainAside = document.getElementById('main-aside-html');

            if (token) { // 로그인 되어 있을 때
                containers.forEach(container => {
                    container.classList.remove('hidden'); // 모든 컨테이너 보여주기
                });

                if (mainAsideLogin && mainAside) {
                    mainAsideLogin.classList.remove('hidden'); // 로그인 창 숨기기
                    mainAside.classList.add('hidden'); // 로그아웃 창 보여주기
                }
            } else { // 로그인 되어 있지 않을 때
                containers.forEach((container, index) => {
                    if (index >= 4) { // 첫 3개 요소 이후부터는
                        container.classList.add('hidden'); // 숨기기
                    }
                });

                if (mainAsideLogin && mainAside) {
                    mainAsideLogin.classList.add('hidden'); // 로그인 창 보여주기
                    mainAside.classList.remove('hidden'); // 로그아웃 창 숨기기
                }
            }
        }

    function updateContainersAndHearts() {
        containers = document.querySelectorAll('.main-item-container');
        hearts = document.querySelectorAll('.heartcheck');
    }

    function toggleHeart(heartElement) {
        if (heartElement.classList.contains('fa-heart')) {
            heartElement.classList.remove('fa-heart');
            heartElement.classList.add('fa-heart-o');
        } else {
            heartElement.classList.add('fa-heart');
            heartElement.classList.remove('fa-heart-o');
        }
    }
