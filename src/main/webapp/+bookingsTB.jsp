<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="adminheader.jsp" %>

<main id="main" class="main">
    <div class="pagetitle">
        <h2>Add a book</h2>
    </div>
    <div class="container shadow p-5">
        <form method="Post" action="AddBookingsServ">
            <div class="form-row">
                <div class="form-group col-md-6 mb-3">
                    <label>Email</label>
                    <input type="text" class="form-control"  placeholder="Email..." name="email">
                    <span  class="alert-dagger"></span>
                </div>
                
                <div class="form-group col-md-6 mb-3">
                    <label>Room ID</label>
                    <input type="text" class="form-control" name="roomid">
                </div>
                
                <div class="form-group col-md-6 mb-3">
                  <label for="inputDate" class="col-sm-2 col-form-label">Check in date</label>
                    <input type="date" class="form-control" name="checkindate">
                </div>
                
                <div class="form-group col-md-6 mb-3">
                  <label for="inputDate" class="col-sm-3 col-form-label">Check out date</label>
                    <input type="date" class="form-control" name="checkoutdate">
                </div>
                
                <div class="form-group col-md-6 mb-3">
                    <label>Total price</label>
                    <input type="text" class="form-control" name="totalprice">
                </div>

                <div class="form-group col-md-6 mb-3">
                    <label>Is paid</label>
                    <select  class="form-select"  name="ispaid">
                        <option value="True">True</option>
                        <option value="False">False</option>
                    </select>
                </div>
                
                <div class="form-group col-md-6 mb-3">
                    <label>State ID</label>
                    <select  class="form-select"  name="stateid">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </select>
                </div>

                
            </div>

            <a  class="btn btn-lg btn-warning p-2">
                <i class="bi bi-arrow-left-circle"></i>
                Go back
            </a>

            <button type="submit" class="btn btn-lg btn-primary p-2">
                <i class="bi bi-file-plus-fill"></i> Save information
            </button>
        </form>
    </div>
</main>

<%@ include file="adminfooter.jsp" %>