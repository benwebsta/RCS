
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Welcome to your profile {{employee.firstName}}</h1>
		
		<br><br><br><br>
          <div class="row placeholders">
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="http://az616578.vo.msecnd.net/files/2017/01/28/636212271908355328-39876855_2000px-Hello_my_name_is_sticker.png" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4></h4>
              <span class="text-muted">{{employee.firstName}} {{employee.lastName}}</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="https://image.freepik.com/free-icon/black-male-user-symbol_318-60703.jpg" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Username</h4>
              <span class="text-muted">{{employee.username}}</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="https://thumb10.shutterstock.com/display_pic_with_logo/3092849/602922167/stock-vector-vector-matrix-background-with-the-green-symbols-stream-of-futuristic-code-symbols-on-screen-602922167.jpg" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Email Address</h4>
              <span class="text-muted">{{employee.email}}</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVTL__2vDka0Z1yOG5nOPb9aAh_JbYGVE2loyjSinMUYf18OCi3q7d-bk" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Apartment</h4>
              <span class="text-muted">{{employeeDTO.address}}</span>
            </div>
          </div>
        </div>
