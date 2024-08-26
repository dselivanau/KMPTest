import SwiftUI
import shared

struct ContentView: View {
//	let greet = Greeting().greet()
    let greet = Greeting()
    
    let viewModel: TestViewModel1 = TestViewModel1()
    @KMPState var countState: Int
    
    init() {
        self._countState = KMPState(stateFlow: viewModel.state, default: 0)
    }

	var body: some View {
        VStack {
//            Text(greet.greet())
//            Text(greet.testFun())
            Text("\(countState)")
            Button("ASDASD") {
                viewModel.increaseCount()
            }
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
