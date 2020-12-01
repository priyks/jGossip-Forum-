<form action="jsps/postregister.jsp" method="post">
<table border="1" cellpadding="0" cellspacing="0" width="100%" class="tablestyle" bordercolor="#999999">
<tr>
	<td colspan="2">
		<div class="divstyle">
		<span class="title">
		Register - required
		</span>
		</div>
	</td>
</tr>
<tr>
	<td class="blockcolor">
		<div class="divstyle">
		<span class="text">
			Username :
		</span>
		</div>
	</td>
	<td>
		<div class="divstyle">
			<input name="username" type="text" size="20">
		</div>
	</td>
</tr>
<tr>
	<td class="blockcolor">
		<div class="divstyle">
		<span class="text">
			Password :
		</span>
		</div>
	</td>
	<td>
		<div class="divstyle">
			<input name="password1" type="password" size="20">
		</div>
	</td>
</tr>
<tr>
	<td class="blockcolor">
		<div class="divstyle">
		<span class="text">
			Retype Password :
		</span>
		</div>
	</td>
	<td>
		<div class="divstyle">
			<input name="password2" type="password" size="20">
		</div>
	</td>
</tr>
<tr>
	<td class="blockcolor">
		<div class="divstyle">
		<span class="text">
			Email :
		</span>
		</div>
	</td>
	<td>
		<div class="divstyle">
			<input name="email" type="text" size="30">
		</div>
	</td>
</tr>
<tr>
	<td colspan="2">
		<div class="divstyle">
		<span class="title">
		Register - optional
		</span>
		</div>
	</td>
</tr>
<tr>
	<td class="blockcolor">
		<div class="divstyle">
		<span class="text">
			Site :
		</span>
		</div>
	</td>
	<td>
		<div class="divstyle">
			<input name="site" type="text" size="40">
		</div>
	</td>
</tr>
<tr>
	<td class="blockcolor">
		<div class="divstyle">
		<span class="text">
			Yahoo ID :
		</span>
		</div>
	</td>
	<td>
		<div class="divstyle">
			<input name="yahooid" type="text" size="30">
		</div>
	</td>
</tr>
<tr>
	<td class="blockcolor">
		<div class="divstyle">
		<span class="text">
			Location :
		</span>
		</div>
	</td>
	<td>
		<div class="divstyle">
			<input name="location" type="text" size="40">
		</div>
	</td>
</tr>
<tr>
	<td class="blockcolor">
		<div class="divstyle">
		<span class="text">
			Birthday :
		</span>
		</div>
	</td>
	<td>
		<div class="divstyle">
			<select name="month">
			<option value="">&nbsp;</option>
			<option value="1">January</option>
			<option value="2">February</option>
			<option value="3">March</option>
			<option value="4">April</option>
			<option value="5">May</option>
			<option value="6">June</option>
			<option value="7">July</option>
			<option value="8">August</option>
			<option value="9">September</option>
			<option value="10">October</option>
			<option value="11">November</option>
			<option value="12">December</option>
			</select>

			<select name="day">
			<option value="">&nbsp;</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
   			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12">12</option>
			<option value="13">13</option>
			<option value="14">14</option>
			<option value="15">15</option>
			<option value="16">16</option>
			<option value="17">17</option>
			<option value="18">18</option>
			<option value="19">19</option>
			<option value="20">20</option>
			<option value="21">21</option>
			<option value="22">22</option>
			<option value="23">23</option>
			<option value="24">24</option>
			<option value="25">25</option>
			<option value="26">26</option>
			<option value="27">27</option>
			<option value="28">28</option>
			<option value="29">29</option>
			<option value="30">30</option>
			<option value="31">31</option>
			</select>
			<input type="text" name="year" size="4">
		</div>
	</td>
</tr>
<tr>
	<td class="blockcolor" valign="top">
		<div class="divstyle">
		<span class="text">
			Bio :
		</span>
		</div>
	</td>
	<td>
		<div class="divstyle">
			<textarea  name="bio" cols="40" rows="5"></textarea>
		</div>
	</td>
</tr>
</table>
<center>
<input type="submit" name="submit" value="Register">
<input type="reset" name="reset" value="Clear All">
</center><p>&nbsp;</p>
