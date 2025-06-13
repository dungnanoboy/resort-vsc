<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!-- footer -->
    <footer class="footer">
        <div class="footer_top">
            <div class="container">
                <div class="row">
                    <div class="col-xl-3 col-md-6 col-lg-3">
                        <div class="footer_widget">
                            <h3 class="footer_title">
                                address
                            </h3>
                            <p class="footer_text"> 300, Nguyen Van Cu, Vinh, <br>
                                Nghe An</p>
                            <a href="#" class="line-button">Get Direction</a>
                        </div>
                    </div>
                    <div class="col-xl-3 col-md-6 col-lg-3">
                        <div class="footer_widget">
                            <h3 class="footer_title">
                                Reservation
                            </h3>
                            <p class="footer_text">+898 649 747 <br>
                                dungnanoboy@dunduth.com</p>
                        </div>
                    </div>
                    <div class="col-xl-2 col-md-6 col-lg-2">
                        <div class="footer_widget">
                            <h3 class="footer_title">
                                Navigation
                            </h3>
                            <ul>
                                <li><a href="#">Home</a></li>
                                <li><a href="#">Rooms</a></li>
                                <li><a href="#">About</a></li>
                                <li><a href="#">News</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-xl-4 col-md-6 col-lg-4">
                        <div class="footer_widget">
                            <h3 class="footer_title">
                                Newsletter
                            </h3>
                            <form action="#" class="newsletter_form">
                                <input type="text" placeholder="Enter your mail">
                                <button type="submit">Sign Up</button>
                            </form>
                            <p class="newsletter_text">Subscribe newsletter to get updates</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="copy-right_text">
            <div class="container">
                <div class="footer_border"></div>
                <div class="row">
                    <div class="col-xl-8 col-md-7 col-lg-9">
                        <p class="copy_right">
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Dunhuth</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </div>
                    <div class="col-xl-4 col-md-5 col-lg-3">
                        <div class="socail_links">
                            <ul>
                                <li>
                                    <a href="#">
                                        <i class="fa fa-facebook-square"></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="fa fa-twitter"></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="fa fa-instagram"></i>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>

    <!-- link that opens popup -->

    <!-- form itself end-->
        <form id="test-form" class="white-popup-block mfp-hide" method="post" action="CheckAvailabilitySrv">
                <div class="popup_box ">
                        <div class="popup_inner">
                            <h3>Check Availability</h3>
                                <div class="row">
                                    <div class="col-xl-6">
                                        <input id="datepicker" name="checkinDate" placeholder="Check in date">
                                    </div>
                                    <div class="col-xl-6">
                                        <input id="datepicker2" name="checkoutDate" placeholder="Check out date">
                                    </div>
                                    <div class="col-xl-12">
                                        <select class="form-select wide" id="default-select" name="occupancy">
                        					<option data-display="Number of people">Number of people</option>
                        					<option value="2">2</option>
                        					<option value="4">4</option>
                        					<option value="6">6</option>
                        					<option value="8">8</option>
                    					</select>
                                    </div>
                                    
                                    <div class="col-xl-12">
                    					<select class="form-select wide" id="default-select" name="roomType">
                        					<option data-display="Room type">Room type</option>
                        					<option value="Standard Room">Standard Room - 2 person</option>
                        					<option value="Deluxe Room">Deluxe Room - 2 person</option>
                        					<option value="Family Room">Family Room - 4 person</option>
                        					<option value="Bungalow">Bungalow Room - 2 person</option>
                        					<option value="Suite">Suite - 4 person</option>
                        					<option value="Presidential Suite">Presidential Suite - 6 person</option>
                        					<option value="Villa">Villa - 8 person</option>
                        					<option value="Pool Villa Room">Pool Villa Room - 2 person</option>
                        					<option value="Luxury Ocean View Suite">Luxury Ocean View Suite - 4 person</option>
                    					</select>
                					</div>
                                    <div class="col-xl-12">
                                        <button type="submit" class="boxed-btn3">Check Availability</button>
                                    </div>
                                </div>
                        </div>
                    </div>
            </form>
    <!-- form itself end -->

    <!-- JS here -->
    <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    
    <script src="js/vendor/modernizr-3.5.0.min.js"></script>
    <script src="js/vendor/jquery-1.12.4.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/isotope.pkgd.min.js"></script>
    <script src="js/ajax-form.js"></script>
    <script src="js/waypoints.min.js"></script>
    <script src="js/jquery.counterup.min.js"></script>
    <script src="js/imagesloaded.pkgd.min.js"></script>
    <script src="js/scrollIt.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/wow.min.js"></script>
    <script src="js/nice-select.min.js"></script>
    <script src="js/jquery.slicknav.min.js"></script>
    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/plugins.js"></script>
    <script src="js/gijgo.min.js"></script>

    <!--contact js-->
    <script src="js/contact.js"></script>
    <script src="js/jquery.ajaxchimp.min.js"></script>
    <script src="js/jquery.form.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/mail-script.js"></script>

    <script src="js/main.js"></script>
    <script>
        $('#datepicker').datepicker({
            iconsLibrary: 'fontawesome',
            icons: {
             rightIcon: '<span class="fa fa-caret-down"></span>'
         }
        });
        $('#datepicker2').datepicker({
            iconsLibrary: 'fontawesome',
            icons: {
             rightIcon: '<span class="fa fa-caret-down"></span>'
         }

        });
    </script>
    
    <script>
    // Lắng nghe sự kiện click trên nút "book now"
    document.querySelectorAll('.popup-with-form').forEach(function(element) {
        element.addEventListener('click', function(event) {
            event.preventDefault(); // Ngăn chặn hành động mặc định của nút

            // Lấy dữ liệu từ thuộc tính data
            var occupancy = this.getAttribute('data-occupancy');
            var typeName = this.getAttribute('data-type-name');

            // Gọi hàm openPopup với dữ liệu đã lấy được
            openPopup(occupancy, typeName);
        });
    });

    function openPopup(occupancy, typeName) {
        console.log("Occupancy:", occupancy);
        console.log("Type Name:", typeName);

        // Đặt giá trị cho các trường input ẩn trong form
        document.getElementById('occupancy').value = occupancy;
        document.getElementById('roomType').value = typeName;

        // Mở form
        document.getElementById('test-form').submit(); // Sử dụng submit() để gửi form đi
    }
</script>




</body>

</html>