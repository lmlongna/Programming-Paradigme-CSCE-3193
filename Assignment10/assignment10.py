from flask import Flask, render_template, request
import random
app = Flask(__name__)

@app.route('/')
@app.route('/assignment10.html', methods=["POST" , "GET"])
def assignment10():
	if len(request.args)==0 and not request.method == "POST":
		return render_template ('assignment101.html')
	elif request.method =="GET" :
		first = request.args.get("firstName")
		last = request.args.get("lastName")
		number = random.randint(1,5)
		print (number)
		
		return render_template('assignment102.html', fN= first, lN = last, number = number )

	else:
	
		guess = request.form["guess"]
		answer = request.form ["answer"]


		if (guess == answer):

			return render_template('good.html' )
			
		else :
			
			return render_template('bad.html', guess= guess ,number= answer)
	

if __name__ == '__main__':
	app.run(debug=True)